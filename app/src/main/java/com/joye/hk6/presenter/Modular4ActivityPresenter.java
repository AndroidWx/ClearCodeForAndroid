package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.HeadTwosActivityVu;
import com.joye.hk6.vu.Modular4ActivityVu;
import com.joye.hk6domain.vo.HeadTwosVo;
import com.joye.hk6domain.vo.Modular4Vo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class Modular4ActivityPresenter extends ConstantsActivityPresenter<Modular4ActivityVu,Modular4Vo>{
    @Inject
    public Modular4ActivityPresenter(@Named("GetModular4UseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);
    }
}
