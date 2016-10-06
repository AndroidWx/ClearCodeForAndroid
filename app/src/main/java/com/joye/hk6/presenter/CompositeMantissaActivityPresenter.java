package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.CompositeMantissaActivityVu;
import com.joye.hk6domain.vo.CompositeMantissaVo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class CompositeMantissaActivityPresenter extends ConstantsActivityPresenter<CompositeMantissaActivityVu,CompositeMantissaVo>{
    @Inject
    public CompositeMantissaActivityPresenter(@Named("GetCompositeMantissaUseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);
    }
}
