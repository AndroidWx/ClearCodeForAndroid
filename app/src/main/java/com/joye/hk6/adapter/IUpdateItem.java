package com.joye.hk6.adapter;

import java.util.List;

/**
 * Created by WX on 2015/9/21.
 * 更新item　动画规范
 */
public interface IUpdateItem<T> {
      void updateItems(List<T> datas, boolean animated);
}
