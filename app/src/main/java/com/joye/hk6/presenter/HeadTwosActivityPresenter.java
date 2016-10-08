package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.ColorTwosActivityVu;
import com.joye.hk6.vu.HeadTwosActivityVu;
import com.joye.hk6domain.vo.ColorTwosVo;
import com.joye.hk6domain.vo.HeadTwosVo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class HeadTwosActivityPresenter extends ConstantsActivityPresenter<HeadTwosActivityVu,HeadTwosVo>{
    @Inject
    public HeadTwosActivityPresenter(@Named("GetHeadTwosUseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);
    }
}
