package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.GateCountActivityVu;
import com.joye.hk6domain.vo.GateCountVo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class GateCountActivityPresenter extends ConstantsActivityPresenter<GateCountActivityVu,GateCountVo>{
    @Inject
    public GateCountActivityPresenter(@Named("GetGateCountUseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);

    }
}
