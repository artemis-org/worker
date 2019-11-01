package io.artemisbot.worker.event

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

object EventBus {

    val _publisher = PublishSubject.create<Event>()

    fun publish(event: Event) = _publisher.onNext(event)

    inline fun<reified T: Event> listen(): Observable<T> = _publisher.ofType(T::class.java)
}