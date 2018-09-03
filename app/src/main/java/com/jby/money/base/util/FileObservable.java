package com.jby.money.base.util;

import io.reactivex.Observable;

public interface FileObservable<R> extends FileHttp<Observable<? extends R>> {
}