package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.ChineseZodiacActivityVu;
import com.joye.hk6.vu.ColorTwosActivityVu;
import com.joye.hk6domain.interactor.GetChineseZodiacUseCase;
import com.joye.hk6domain.vo.ChineseZodiacVo;
import com.joye.hk6domain.vo.ColorTwosVo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class ChineseZodiacActivityPresenter extends ConstantsActivityPresenter<ChineseZodiacActivityVu,ChineseZodiacVo>{
    @Inject
    public ChineseZodiacActivityPresenter(@Named("GetChineseZodiacUseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);

    }
}
