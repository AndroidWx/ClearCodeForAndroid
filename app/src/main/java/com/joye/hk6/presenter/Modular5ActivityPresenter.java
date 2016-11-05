package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.Modular5ActivityVu;
import com.joye.hk6domain.vo.Modular5Vo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class Modular5ActivityPresenter extends ConstantsActivityPresenter<Modular5ActivityVu,Modular5Vo>{
    @Inject
    public Modular5ActivityPresenter(@Named("GetModular5UseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);
    }
}
