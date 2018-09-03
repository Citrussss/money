package com.jby.money.base.rxjava;

import com.jby.money.base.util.InfoEntity;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;

/**
 * Created by arvin on 2017/11/30.
 */

public class RestfulFlowTransformer<T> implements FlowableTransformer<InfoEntity<T>, T> {
    private final BackpressureStrategy model;

    public RestfulFlowTransformer() {
        this(BackpressureStrategy.ERROR);
    }

    public RestfulFlowTransformer(BackpressureStrategy model){
        this.model = model;
    }

    @Override
    public Publisher<T> apply(Flowable<InfoEntity<T>> upstream) {
        return upstream
                .concatMap(entity -> Flowable.create(flowableEmitter -> {
                    try {
                        if (entity.getData() != null) flowableEmitter.onNext(entity.getData());
                    } catch (Exception e) {
                        flowableEmitter.onError(e);
                    } finally {
                        flowableEmitter.onComplete();
                    }
                }, model)
        );
    }
}
