package consumers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import resource.changes.ResourceChange;

public class ConsoleResourceConsumer implements Observer<ResourceChange> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        System.out.println("Console Consumer Subscribed");
    }

    @Override
    public void onNext(@NonNull ResourceChange resourceChange) {
        System.out.println(resourceChange);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        System.out.println("On Error");
    }

    @Override
    public void onComplete() {
        System.out.println("On Complete");
    }
}
