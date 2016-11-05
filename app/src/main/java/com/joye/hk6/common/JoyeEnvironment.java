package com.joye.hk6.common;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.graphics.Point;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 获得Joye程序的环境设置. 为程序提供:
 * <ul>
 * <li>检测当前 SDCard是否mount,是否可写 {@link #check()} {@link #available()}
 * {@link #writable()}</li>
 * <li>获取SDCard的根目录文件 {@link #getExternalStorageRoot()}</li>
 * <li>获得本应用程序的包名和简单包名 {@link #getPackageName()} {@link #getSimplePackageName()}
 * </li>
 * <li>获得本应用程序在 SDcard上的起始目录 {@link #getExternalStorageRoot()}, 该目录是在SDCard
 * mounted 的根目录下以 {@link #getPackageName()}为名字子目录</li>
 * </ul>
 * 用法:
 * <ol>
 * <li>在 app 启动时,调用本类的静态方法 {@link #onCreate(Context)}初始化本类环境</li>
 * <li>在需要使用本类提供的功能代码中使用静态方法 {@link #get()}获得本类的单例实例对象</li>
 * </ol>
 * 
 * @author W,x 
 *
 */
public enum JoyeEnvironment {

	Instance;

	private Lock lock;

	private boolean unregist;

	  JoyeEnvironment() {
		lock = new ReentrantLock();
		unregist = true;
	}

	private final String TAG = JoyeEnvironment.class.getSimpleName();

	/**
	 * SDCard可用(可写需要参考 {@link #STORAGE_WRITEABLE}
	 */
	public final static byte STORAGE_AVAILABLE = 1;

	/**
	 * SDCard可写
	 */
	public final static byte STORAGE_WRITEABLE = 1 << 1;

	private File externalStorageRoot = null;

	private String packageName;

	private String simplePackageName;

	private AssetManager assets;

	private int versionCode;

	private String versionName;

	private long installed;

	private Display display;

	private TelephonyManager telephonyManager;

	/**
	 * 默认屏幕大小
	 */
	private Point defaultScreenSize;

	private boolean openGLES2;

	private boolean cameraHardware;
	
	private DisplayMetrics displayMetrics;
	public   boolean isEmpty(CharSequence cs) {
		return cs == null || cs.length() == 0;
	}
	public   String substringAfterLast(String str, String separator) {
		if(isEmpty(str)) {
			return str;
		} else if(isEmpty(separator)) {
			return "";
		} else {
			int pos = str.lastIndexOf(separator);
			return pos != -1 && pos != str.length() - separator.length()?str.substring(pos + separator.length()):"";
		}
	}
	/**
	 * 初始化方法
	 * 
	 * @param c
	 */
	public void onCreate(Context c) {
		lock.lock();
		try {
			packageName = c.getPackageName();
			simplePackageName =substringAfterLast(packageName, ".");
			assets = c.getAssets();
			initVersion(c);
			display = ((WindowManager) c
					.getSystemService(Context.WINDOW_SERVICE))
					.getDefaultDisplay();
			defaultScreenSize = new Point();
			display.getSize(defaultScreenSize);
			telephonyManager = (TelephonyManager) c
					.getSystemService(Context.TELEPHONY_SERVICE);
			unregist = false;

			final ActivityManager activityManager = (ActivityManager) c
					.getSystemService(Context.ACTIVITY_SERVICE);
			final ConfigurationInfo configurationInfo = activityManager
					.getDeviceConfigurationInfo();
			openGLES2 = configurationInfo.reqGlEsVersion >= 0x20000;
			cameraHardware = c.getPackageManager().hasSystemFeature(
				PackageManager.FEATURE_CAMERA);

			displayMetrics=new DisplayMetrics();
			display.getMetrics(displayMetrics);
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 当前SDCard的可用和读写状态 {@value #STORAGE_AVAILABLE} |
	 * {@value #STORAGE_WRITEABLE}
	 * 
	 * @return 读写状态的位标记
	 */
	public byte check() {
		validate();
		byte storageState = 0;
		String state = Environment.getExternalStorageState();

		if (Environment.MEDIA_MOUNTED.equals(state)) {
			// We can read and write the media
			storageState |= STORAGE_AVAILABLE | STORAGE_WRITEABLE;
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			// We can only read the media
			storageState |= STORAGE_AVAILABLE;
		}
		return storageState;
	}

	/**
	 * SD卡是否可用
	 * 
	 * @return <code>true</code> 可用,否则<code>false</code>
	 */
	public boolean available() {
		return (check() & STORAGE_AVAILABLE) == STORAGE_AVAILABLE;
	}

	/**
	 * 可写性
	 * 
	 * @return <code>true</code>可写,否则<code>false</code>
	 */
	public boolean writable() {
		return check() == (STORAGE_AVAILABLE | STORAGE_WRITEABLE);
	}

	private void initVersion(Context context) {
		String packageName = context.getApplicationContext().getPackageName();
		int flags = 0;
		PackageInfo packageInfo = null;
		try {
			packageInfo = context.getPackageManager().getPackageInfo(
					packageName, flags);
		} catch (NameNotFoundException e) {
			Log.e(TAG, e.getMessage());
		}
		versionCode = packageInfo.versionCode;
		versionName = packageInfo.versionName;
		String appFile = null;
		try {
			appFile = context.getPackageManager().getApplicationInfo(
					packageName, flags).sourceDir;
		} catch (NameNotFoundException e) {
			Log.e(TAG, e.getMessage());
		}
		installed = 0;
		try {
			installed = new File(appFile).lastModified();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}
	}

	public int getVersionCode() {
		validate();
		return versionCode;
	}

	public String getVersionName() {
		validate();
		return versionName;
	}

	public long getInstalled() {
		validate();
		return installed;
	}

	/**
	 * 单例实例
	 * 
	 * @return 单例实例
	 */
	private JoyeEnvironment validate() {
		lock.lock();
		try {
			if (unregist)
				throw new UnsupportedOperationException("un-regist");
		} finally {
			lock.unlock();
		}

		return this;
	}

	/**
	 * SDCard根目录
	 * <p>
	 * 不使用 context.getExternalFilesDir(null)的方法获取
	 * Android/data目录,该目录是缓存目录,当程序卸载或重装时, 该目录的内容将被删除
	 * </p>
	 * 
	 * @return 根目录
	 */
	@SuppressLint("NewApi")
	public File getExternalStorageRoot() {
		validate();
		if (externalStorageRoot == null) {
			if (available()) {
				// if(Build.VERSION.SDK_INT < 8){
				externalStorageRoot = new File(
						Environment.getExternalStorageDirectory(), packageName);
				// }else{
				// externalStorageRoot = context.getExternalFilesDir(null);
				// }
			} else {
				externalStorageRoot = new AppDataDirGuesser().guess();
			}
		}
		return externalStorageRoot;
	}

	/**
	 * 获取 APP 外部存储目录下指定名词的子目录文件句柄
	 * 
	 * @param name
	 *            子目录名称
	 * @return APP 外部存储目录下指定名词的子目录文件句柄，已经完成必要的文件夹创建工作（如果不存在则自动创建）
	 */
	public File getExternalStorageForName(String name) {
		validate();
		File file = null;
		if (writable()) {
			file = new File(getExternalStorageRoot(), name);
			if (!file.isDirectory()) {
				file.mkdirs();
			}
		} else {
			file = new AppDataDirGuesser().guess(name);
		}
		return file;
	}

	/**
	 * 本应用程序的包名(装货清单)
	 * 
	 * @return {@link Context#getPackageName()}
	 */
	public String getPackageName() {
		validate();
		return packageName;
	}

	/**
	 * 取 {@link #getPackageName()}中出现在最后一个dot(.)的字符串
	 * 
	 * @return {@link #getPackageName()}的简单名称
	 */
	public String getSimplePackageName() {
		validate();
		return simplePackageName;
	}

	/**
	 * 打开一个资源文件
	 * 
	 * @param fileName
	 *            资源文件名
	 * @return 该文件的流
	 * @throws IOException
	 */
	public InputStream getAssetsFile(String fileName) throws IOException {
		validate();
		return assets.open(fileName);
	}

	/**
	 * 获取资源文件夹中指定目录下的文件列表
	 * 
	 * @param path
	 *            待查找的目录
	 * @return 该目录下的文件列表，相对于 assets。
	 * @throws IOException
	 */
	public String[] getAssetsFiles(String path) throws IOException {
		validate();
		String[] files = assets.list(path);
		for (int i = 0; i < files.length; i++) {
			StringBuilder sb = new StringBuilder(path);
			sb.append(File.separatorChar);
			sb.append(files[i]);
			files[i] = sb.toString();
		}
		return files;
	}

	/**
	 * 系统默认显示器
	 * 
	 * @return 系统默认显示器
	 */
	public Display getDisplay() {
		validate();
		return display;
	}

	/**
	 * 是否安全
	 * 
	 * @param sdk
	 * @return
	 */
	public boolean fitSdk(int sdk) {
		return android.os.Build.VERSION.SDK_INT >= sdk;
	}

	/**
	 * Returns the software version number for the device, for example, the
	 * IMEI/SV for GSM phones. Return null if the software version is not
	 * available.
	 * 
	 * @return 系统软件版本号
	 */
	public String getDevVersion() {
		return telephonyManager.getDeviceSoftwareVersion();
	}

	/**
	 * The current development codename, or the string "REL" if this is a
	 * release build.
	 * 
	 * @return
	 */
	public String getBuildCodeName() {
		return android.os.Build.VERSION.CODENAME;
	}

	/**
	 * The user-visible SDK version of the framework; its possible values are
	 * defined in Build.VERSION_CODES.
	 * 
	 * @return
	 */
	public int getBuildSdk() {
		return android.os.Build.VERSION.SDK_INT;
	}

	/**
	 * The internal value used by the underlying source control to represent
	 * this build. E.g., a perforce changelist number or a git hash.
	 * 
	 * @return
	 */
	public String getBuildIncremental() {
		return android.os.Build.VERSION.INCREMENTAL;
	}

	public String getBuildRelease() {
		return android.os.Build.VERSION.RELEASE;
	}

	/**
	 * Returns the phone number string for line 1, for example, the MSISDN for a
	 * GSM phone. Return null if it is unavailable.
	 * 
	 * Requires Permission: READ_PHONE_STATE
	 * 
	 * @return
	 */
	public String getLine1Number() {
		try {
			return telephonyManager.getLine1Number();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Returns a constant indicating the device phone type. This indicates the
	 * type of radio used to transmit voice calls.
	 * 
	 * See Also: PHONE_TYPE_NONE PHONE_TYPE_GSM PHONE_TYPE_CDMA PHONE_TYPE_SIP
	 * 
	 * @return
	 */
	public int getPhoneType() {
		return telephonyManager.getPhoneType();
	}

	/**
	 * Returns the numeric name (MCC+MNC) of current registered operator.
	 * 
	 * Availability: Only when user is registered to a network. Result may be
	 * unreliable on CDMA networks (use getPhoneType() to determine if on a CDMA
	 * network).
	 * 
	 * @return
	 */
	public String getNetworkOperator() {
		return telephonyManager.getNetworkOperator();
	}

	/**
	 * Returns a constant indicating the radio technology (network type)
	 * currently in use on the device for data transmission.
	 * 
	 * Returns: the network type See Also: NETWORK_TYPE_UNKNOWN
	 * NETWORK_TYPE_GPRS NETWORK_TYPE_EDGE NETWORK_TYPE_UMTS NETWORK_TYPE_HSDPA
	 * NETWORK_TYPE_HSUPA NETWORK_TYPE_HSPA NETWORK_TYPE_CDMA
	 * NETWORK_TYPE_EVDO_0 NETWORK_TYPE_EVDO_A NETWORK_TYPE_EVDO_B
	 * NETWORK_TYPE_1xRTT NETWORK_TYPE_IDEN NETWORK_TYPE_LTE NETWORK_TYPE_EHRPD
	 * NETWORK_TYPE_HSPAP
	 * 
	 * @return
	 */
	public int getNetworkType() {
		return telephonyManager.getNetworkType();
	}

	/**
	 * Returns the ISO country code equivalent for the SIM provider's country
	 * code.
	 * 
	 * @return
	 */
	public String getSimCountryIso() {
		return telephonyManager.getSimCountryIso();
	}

	/**
	 * Returns the Service Provider Name (SPN).
	 * 
	 * Availability: SIM state must be SIM_STATE_READY
	 * 
	 * See Also: getSimState
	 * 
	 * @return
	 */
	public String getSimOperatorName() {
		return telephonyManager.getSimOperatorName();
	}

	/**
	 * Returns the unique subscriber ID, for example, the IMSI for a GSM phone.
	 * Return null if it is unavailable.
	 * 
	 * Requires Permission: READ_PHONE_STATE
	 * 
	 * @return
	 */
	public String getSubscriberId() {
		return telephonyManager.getSubscriberId();
	}

	/**
	 * 网络运营商名称
	 * 
	 * @return 移动联通电信等
	 */
	public String getNetworkOperatorName() {
		return telephonyManager.getNetworkOperatorName();
	}

	/**
	 * 默认屏幕高度
	 * 
	 * @return
	 */
	public int getScreenHeight() {
		return defaultScreenSize.y;
	}

	/**
	 * 默认屏幕的宽度
	 * 
	 * @return
	 */
	public int getScreenWidth() {
		return defaultScreenSize.x;
	}

	/**
	 * 获取手机IMEI 唯一标识码
	 * 
	 * @return 2014年12月31日-上午11:25:32
	 * 
	 */
	public String getImei() {
		return telephonyManager.getDeviceId();
	}

	/**
	 * The manufacturer of the product/hardware.
	 * 
	 * @return
	 */
	public String getManufacturer() {
		return android.os.Build.MANUFACTURER;
	}

	/**
	 * The brand (e.g., carrier) the software is customized for, if any.
	 * 
	 * @return
	 */
	public String getBrand() {
		return android.os.Build.BRAND;
	}

	/**
	 * The end-user-visible name for the end product.
	 * 
	 * @return
	 */
	public String getModel() {
		return android.os.Build.MODEL;
	}

	/**
	 * 是否有摄像头功能
	 * 
	 * @param context
	 * @return <code>true</code>有
	 */
	public boolean checkCameraHardware(Context context) {
		return cameraHardware;
	}

	/**
	 * 检测当前设备是否支持 OpenGL ES 2.0
	 * 
	 * @return <code>true</code>支持
	 */
	public boolean supportsOpenGLES2() {
		return openGLES2;
	}

	public DisplayMetrics getDisplayMetrics() {
		return displayMetrics;
	}
	
}
