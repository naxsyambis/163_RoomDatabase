package com.example.a163_roomdatabase.repositori

import com.example.a163_roomdatabase.room.Siswa
import com.example.a163_roomdatabase.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
    // tambah 3 fungsi

    fun getSiswaStream(id: Int): Flow<Siswa?> //    ?null safety

    suspend fun deleteSiswa(siswa: Siswa)

    suspend fun updateSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa( // turunan dari atas, cara menggunakannya harus di overide
    private val siswaDao: SiswaDao
): RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override  suspend fun  insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
    //edit 2: tambah 3 overide berikut
    override fun getSiswaStream(id: Int): Flow<Siswa?> = siswaDao.getSiswa(id)
    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)
    override suspend fun updateSiswa(siswa: Siswa) = siswaDao.update(siswa)
}
