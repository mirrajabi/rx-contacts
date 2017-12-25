package ir.mirrajabi.rxcontacts.app;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ir.mirrajabi.rxcontacts.Contact;
import ir.mirrajabi.rxcontacts.RxContacts;

/**
 * @author Ulrich Raab
 * @author MADNESS
 */
public class MainActivity extends AppCompatActivity {

    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeRecyclerView();
        requestContacts();
    }

    private void initializeRecyclerView () {
        ContactAdapter contactAdapter = getContactAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView_contacts);
        if (rv != null) {
            rv.setAdapter(contactAdapter);
            rv.setLayoutManager(linearLayoutManager);
        }
    }

    private ContactAdapter getContactAdapter () {
        if (contactAdapter != null) {
            return contactAdapter;
        }
        contactAdapter = new ContactAdapter();
        return contactAdapter;
    }

    private void requestContacts () {
        RxContacts
            .fetch(this)
            .filter(m->m.getInVisibleGroup() == 1)
            .toSortedList(Contact::compareTo)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(contacts -> {
                ContactAdapter adapter = getContactAdapter();
                adapter.setContacts(contacts);
                adapter.notifyDataSetChanged();
            }, it -> {
                //Handle exception
            });
    }
}
