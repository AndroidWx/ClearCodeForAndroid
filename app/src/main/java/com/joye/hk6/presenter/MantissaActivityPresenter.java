package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.MantissaActivityVu;
import com.joye.hk6domain.vo.MantissaVo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class MantissaActivityPresenter extends ConstantsActivityPresenter<MantissaActivityVu,MantissaVo>{
    @Inject
    public MantissaActivityPresenter(@Named("GetMantissaUseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);


    }
}
