package com.example.a163_roomdatabase.repositori

import com.example.a163_roomdatabase.room.Siswa
import com.example.a163_roomdatabase.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
    // tambah 3 fungsi

//    fun getSiswaStream(id: Int): Flow<Siswa?>
    //?null safety

//    suspend fun deleteSiswa(siswa: Siswa)

//    suspend fun updateSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
): RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override  suspend fun  insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}
