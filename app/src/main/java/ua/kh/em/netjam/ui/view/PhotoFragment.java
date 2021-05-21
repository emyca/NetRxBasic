package ua.kh.em.netjam.ui.view;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ua.kh.em.netjam.R;
import ua.kh.em.netjam.ui.adapter.PhotoAdapter;
import ua.kh.em.netjam.data.model.Photo;
import ua.kh.em.netjam.utils.CheckNet;
import ua.kh.em.netjam.ui.viewmodel.PhotoViewModel;

public class PhotoFragment extends Fragment {

    Context context;
    RecyclerView recyclerView;
    ArrayList<Photo> list;
    PhotoAdapter adapter;
    private View view;
    CompositeDisposable disposable;
    ProgressBar progressBar;
    PhotoViewModel viewModel;

    public static PhotoFragment newInstance() {
        return new PhotoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_photo, container, false);
        disposable = new CompositeDisposable();
        initViews();
        setupRecyclerView();
        if (CheckNet.isNetExists(context)) {
            progressBar.setVisibility(View.GONE);
        }
        return view;
    }

    private void initViews() {
        progressBar = view.findViewById(R.id.progressbar);
        recyclerView = view.findViewById(R.id.list_photos);
    }

    private void setupRecyclerView() {
        if (adapter == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
            // RecyclerView divider line
            LinearLayoutManager linearLayoutManager =
                    new LinearLayoutManager(requireActivity());
            RecyclerView.ItemDecoration itemDecoration =
                    new DividerItemDecoration(recyclerView.getContext(),
                            linearLayoutManager.getOrientation());
            recyclerView.addItemDecoration(itemDecoration);

            recyclerView.setHasFixedSize(true);
            list = new ArrayList<>();
            adapter = new PhotoAdapter(list);
            recyclerView.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PhotoViewModel.class);
        disposable.add(viewModel.loadPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse,this::handleError));
    }

    private void handleResponse(List<Photo> photos) {
        if (photos != null) {
            progressBar.setVisibility(View.GONE);
            adapter.addListPhoto(photos);
        }else if (list.isEmpty()) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(context, R.string.something_wrong, Toast.LENGTH_LONG).show();
        }
    }

    private void handleError(Throwable throwable) {
        Toast.makeText(requireActivity(), R.string.something_wrong,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
        }
    }
}