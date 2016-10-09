package com.joye.hk6.internal.di.modules;

import com.joye.basedomain.executor.PostExecutionThread;
import com.joye.basedomain.executor.ThreadExecutor;
import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6domain.interactor.GetChineseZodiacUseCase;
import com.joye.hk6domain.interactor.GetColorTwosUseCase;
import com.joye.hk6domain.interactor.GetColorUseCase;
import com.joye.hk6domain.interactor.GetCompositeCase;
import com.joye.hk6domain.interactor.GetCompositeMantissaUseCase;
import com.joye.hk6domain.interactor.GetCompositeSizeUseCase;
import com.joye.hk6domain.interactor.GetGateCountUseCase;
import com.joye.hk6domain.interactor.GetHeadAgeUseCase;
import com.joye.hk6domain.interactor.GetHeadTwosUseCase;
import com.joye.hk6domain.interactor.GetHk6Data;
import com.joye.hk6domain.interactor.GetMantissaSizeUseCase;
import com.joye.hk6domain.interactor.GetMantissaUseCase;
import com.joye.hk6domain.interactor.GetModular3UseCase;
import com.joye.hk6domain.interactor.GetModular4UseCase;
import com.joye.hk6domain.interactor.GetModular5UseCase;
import com.joye.hk6domain.interactor.GetModular6UseCase;
import com.joye.hk6domain.interactor.GetModular7UseCase;
import com.joye.hk6domain.interactor.GetRegionUseCase;
import com.joye.hk6domain.interactor.GetSizeTwosUseCase;
import com.joye.hk6domain.interactor.GetSizeUseCase;
import com.joye.hk6domain.repository.Hk6Repository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by W,x (JoyeWang)
 * on 2016/9/23.
 * 304622254@qq.com
 * Remeark:
 */
@Module
public class Hk6Module {
    private String date="";

    public Hk6Module(String date) {
        this.date = date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Provides @PerActivity @Named("GetHk6Data")
    UseCase provideGetHk6DataUseCase(ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetHk6Data(threadExecutor,postExecutionThread,hk6Repository,date);
    }
    @Provides @PerActivity @Named("GetChineseZodiacUseCase")
    UseCase provideGetChineseZodiacUseCase(ThreadExecutor threadExecutor,
                                           PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetChineseZodiacUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

    @Provides @PerActivity @Named("GetSizeUseCase")
    UseCase provideGetSizeUseCase(ThreadExecutor threadExecutor,
                                           PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetSizeUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

    @Provides @PerActivity @Named("GetRegionUseCase")
    UseCase provideGetRegionUseCase(ThreadExecutor threadExecutor,
                                  PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetRegionUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

    @Provides @PerActivity @Named("GetColorTwosUseCase")
    UseCase provideGetColorTwosUseCase(ThreadExecutor threadExecutor,
                                    PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetColorTwosUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }
    @Provides @PerActivity @Named("GetHeadAgeUseCase")
    UseCase provideGetHeadAgeUseCase(ThreadExecutor threadExecutor,
                                       PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetHeadAgeUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

    @Provides @PerActivity @Named("GetCompositeCase")
    UseCase provideGetCompositeCase(ThreadExecutor threadExecutor,
                                     PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetCompositeCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

    @Provides @PerActivity @Named("GetGateCountUseCase")
    UseCase provideGetGateCountUseCase(ThreadExecutor threadExecutor,
                                       PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetGateCountUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }


    @Provides @PerActivity @Named("GetMantissaUseCase")
    UseCase provideGetMantissaUseCase(ThreadExecutor threadExecutor,
                                       PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetMantissaUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

    @Provides @PerActivity @Named("GetCompositeSizeUseCase")
    UseCase provideGetCompositeSizeUseCase(ThreadExecutor threadExecutor,
                                           PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetCompositeSizeUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

    @Provides @PerActivity @Named("GetMantissaSizeUseCase")
    UseCase provideGetMantissaSizeUseCase(ThreadExecutor threadExecutor,
                                           PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetMantissaSizeUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

    @Provides @PerActivity @Named("GetSizeTwosUseCase")
    UseCase provideGetSizeTwosUseCase(ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetSizeTwosUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }
    @Provides @PerActivity @Named("GetCompositeMantissaUseCase")
    UseCase provideGetCompositeMantissaUseCase(ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetCompositeMantissaUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

    @Provides @PerActivity @Named("GetHeadTwosUseCase")
    UseCase provideGetHeadTwosUseCase(ThreadExecutor threadExecutor,
                                               PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetHeadTwosUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }
    @Provides @PerActivity @Named("GetModular3UseCase")
    UseCase provideGetModular3UseCase(ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetModular3UseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

    @Provides @PerActivity @Named("GetModular4UseCase")
    UseCase provideGetModular4UseCase(ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetModular4UseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }
    @Provides @PerActivity @Named("GetModular5UseCase")
    UseCase provideGetModular5UseCase(ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetModular5UseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }
    @Provides @PerActivity @Named("GetModular6UseCase")
    UseCase provideGetModular6UseCase(ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetModular6UseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

    @Provides @PerActivity @Named("GetModular7UseCase")
    UseCase provideGetModular7UseCase(ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetModular7UseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

    @Provides @PerActivity @Named("GetColorUseCase")
    UseCase provideGetColorUseCase(ThreadExecutor threadExecutor,
                                      PostExecutionThread postExecutionThread , Hk6Repository hk6Repository){
        return new
                GetColorUseCase(threadExecutor,postExecutionThread,hk6Repository,date);
    }

}
