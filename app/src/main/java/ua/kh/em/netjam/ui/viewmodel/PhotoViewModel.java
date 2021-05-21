package ua.kh.em.netjam.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.Flowable;
import ua.kh.em.netjam.data.model.Photo;
import ua.kh.em.netjam.data.repository.AppRepository;

public class PhotoViewModel extends ViewModel {

    AppRepository repository = new AppRepository();

    public Flowable<List<Photo>> loadPhotos() {
        return repository.loadPhotos();
    }
}