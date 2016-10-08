package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.HeadTwosActivityVu;
import com.joye.hk6.vu.Modular6ActivityVu;
import com.joye.hk6domain.vo.HeadTwosVo;
import com.joye.hk6domain.vo.Modular6Vo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class Modular6ActivityPresenter extends ConstantsActivityPresenter<Modular6ActivityVu,Modular6Vo>{
    @Inject
    public Modular6ActivityPresenter(@Named("GetModular6UseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);
    }
}
