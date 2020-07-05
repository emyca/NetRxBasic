package ua.kh.em.netrxbasic.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.Flowable;
import ua.kh.em.netrxbasic.model.Photo;
import ua.kh.em.netrxbasic.repository.AppRepository;

public class PhotoViewModel extends ViewModel {

    AppRepository repository = new AppRepository();

    public Flowable<List<Photo>> loadPhotos() {
        return repository.loadPhotos();
    }
}