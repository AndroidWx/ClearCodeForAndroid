package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.SizeTwosActivityVu;
import com.joye.hk6domain.vo.SizeTwosVo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class SizeTowsPresenter extends ConstantsActivityPresenter<SizeTwosActivityVu,SizeTwosVo>{
    @Inject
    public SizeTowsPresenter(@Named("GetSizeTwosUseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);
    }
}
