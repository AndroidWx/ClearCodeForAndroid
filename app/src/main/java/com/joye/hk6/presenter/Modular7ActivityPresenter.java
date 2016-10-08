package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.HeadTwosActivityVu;
import com.joye.hk6.vu.Modular7ActivityVu;
import com.joye.hk6domain.vo.HeadTwosVo;
import com.joye.hk6domain.vo.Modular7Vo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class Modular7ActivityPresenter extends ConstantsActivityPresenter<Modular7ActivityVu,Modular7Vo>{
    @Inject
    public Modular7ActivityPresenter(@Named("GetModular7UseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);
    }
}
