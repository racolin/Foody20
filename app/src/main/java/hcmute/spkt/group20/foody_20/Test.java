package hcmute.spkt.group20.foody_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import hcmute.spkt.group20.foody_20.dao.CommentDao;
import hcmute.spkt.group20.foody_20.model.Comment;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.createData();
    }
}