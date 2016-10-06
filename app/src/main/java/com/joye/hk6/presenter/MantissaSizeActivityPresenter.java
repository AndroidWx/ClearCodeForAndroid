package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.MantissaSizeActivityVu;
import com.joye.hk6domain.vo.MantissaSizeVo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class MantissaSizeActivityPresenter extends ConstantsActivityPresenter<MantissaSizeActivityVu,MantissaSizeVo>{
    @Inject
    public MantissaSizeActivityPresenter(@Named("GetMantissaSizeUseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);


    }
}
