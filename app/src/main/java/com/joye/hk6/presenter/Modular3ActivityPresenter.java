package com.joye.hk6.presenter;

import com.joye.basedomain.interactor.UseCase;
import com.joye.basepresentation.internal.di.PerActivity;
import com.joye.hk6.vu.HeadTwosActivityVu;
import com.joye.hk6.vu.Modular3ActivityVu;
import com.joye.hk6domain.interactor.GetModular3UseCase;
import com.joye.hk6domain.vo.HeadTwosVo;
import com.joye.hk6domain.vo.Modular3Vo;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xiang on 16/9/29.
 */
@PerActivity
public class Modular3ActivityPresenter extends ConstantsActivityPresenter<Modular3ActivityVu,Modular3Vo>{
    @Inject
    public Modular3ActivityPresenter(@Named("GetModular3UseCase") UseCase getHk6DataUseCase) {
        super(getHk6DataUseCase);
    }
}
