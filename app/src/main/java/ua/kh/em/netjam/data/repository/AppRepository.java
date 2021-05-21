package ua.kh.em.netjam.data.repository;


import java.util.List;

import io.reactivex.Flowable;
import ua.kh.em.netjam.data.model.Photo;
import ua.kh.em.netjam.data.model.Post;
import ua.kh.em.netjam.data.model.User;
import ua.kh.em.netjam.data.network.ApiClient;
import ua.kh.em.netjam.data.network.ApiService;

public class AppRepository {

    ApiService api;

    public Flowable<List<Post>> loadPosts() {
        api = ApiClient.getApiService();
        return api.loadPosts();
    }

    public Flowable<List<Photo>> loadPhotos() {
        api = ApiClient.getApiService();
        return api.loadPhotos();
    }

    public Flowable<List<User>> loadUsers() {
        api = ApiClient.getApiService();
        return api.loadUsers();
    }
}
