package com.projek.rajaongkir.network;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DataOngkirDAO_Impl implements DataOngkirDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DataOngkir> __insertionAdapterOfDataOngkir;

  private final EntityDeletionOrUpdateAdapter<DataOngkir> __deletionAdapterOfDataOngkir;

  private final EntityDeletionOrUpdateAdapter<DataOngkir> __updateAdapterOfDataOngkir;

  public DataOngkirDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDataOngkir = new EntityInsertionAdapter<DataOngkir>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ongkir_db` (`id`,`nama`,`alamat`,`telpon`,`ongkir`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DataOngkir value) {
        stmt.bindLong(1, value.getId());
        if (value.getNama() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama());
        }
        if (value.getAlamat() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAlamat());
        }
        if (value.getTelpon() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTelpon());
        }
        if (value.getOngkir() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOngkir());
        }
      }
    };
    this.__deletionAdapterOfDataOngkir = new EntityDeletionOrUpdateAdapter<DataOngkir>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ongkir_db` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DataOngkir value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfDataOngkir = new EntityDeletionOrUpdateAdapter<DataOngkir>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ongkir_db` SET `id` = ?,`nama` = ?,`alamat` = ?,`telpon` = ?,`ongkir` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DataOngkir value) {
        stmt.bindLong(1, value.getId());
        if (value.getNama() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama());
        }
        if (value.getAlamat() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAlamat());
        }
        if (value.getTelpon() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTelpon());
        }
        if (value.getOngkir() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOngkir());
        }
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public Long insertData(final DataOngkir dataOngkir) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfDataOngkir.insertAndReturnId(dataOngkir);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteData(final DataOngkir item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDataOngkir.handle(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateData(final DataOngkir item) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfDataOngkir.handle(item);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<DataOngkir> getData() {
    final String _sql = "Select * from ongkir_db";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNama = CursorUtil.getColumnIndexOrThrow(_cursor, "nama");
      final int _cursorIndexOfAlamat = CursorUtil.getColumnIndexOrThrow(_cursor, "alamat");
      final int _cursorIndexOfTelpon = CursorUtil.getColumnIndexOrThrow(_cursor, "telpon");
      final int _cursorIndexOfOngkir = CursorUtil.getColumnIndexOrThrow(_cursor, "ongkir");
      final List<DataOngkir> _result = new ArrayList<DataOngkir>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final DataOngkir _item;
        _item = new DataOngkir();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNama;
        if (_cursor.isNull(_cursorIndexOfNama)) {
          _tmpNama = null;
        } else {
          _tmpNama = _cursor.getString(_cursorIndexOfNama);
        }
        _item.setNama(_tmpNama);
        final String _tmpAlamat;
        if (_cursor.isNull(_cursorIndexOfAlamat)) {
          _tmpAlamat = null;
        } else {
          _tmpAlamat = _cursor.getString(_cursorIndexOfAlamat);
        }
        _item.setAlamat(_tmpAlamat);
        final String _tmpTelpon;
        if (_cursor.isNull(_cursorIndexOfTelpon)) {
          _tmpTelpon = null;
        } else {
          _tmpTelpon = _cursor.getString(_cursorIndexOfTelpon);
        }
        _item.setTelpon(_tmpTelpon);
        final String _tmpOngkir;
        if (_cursor.isNull(_cursorIndexOfOngkir)) {
          _tmpOngkir = null;
        } else {
          _tmpOngkir = _cursor.getString(_cursorIndexOfOngkir);
        }
        _item.setOngkir(_tmpOngkir);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
