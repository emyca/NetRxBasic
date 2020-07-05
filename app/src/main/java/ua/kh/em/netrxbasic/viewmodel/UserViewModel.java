package ua.kh.em.netrxbasic.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.Flowable;
import ua.kh.em.netrxbasic.model.User;
import ua.kh.em.netrxbasic.repository.AppRepository;

public class UserViewModel extends ViewModel {

    AppRepository repository = new AppRepository();

    public Flowable<List<User>> loadUsers() {
        return repository.loadUsers();
    }
}