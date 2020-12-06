package ua.kh.em.netjam.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.Flowable;
import ua.kh.em.netjam.model.User;
import ua.kh.em.netjam.repository.AppRepository;

public class UserViewModel extends ViewModel {

    AppRepository repository = new AppRepository();

    public Flowable<List<User>> loadUsers() {
        return repository.loadUsers();
    }
}