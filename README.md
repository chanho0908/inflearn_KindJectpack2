# 인프런 친절한 JETPACK 개론
출처 : [ https://www.inflearn.com/course/%EC%B9%9C%EC%A0%88%ED%95%9C-jetpack-2/dashboard ]

### Chap1. Databinding (TwoWay binding/Binding Adapter)<br>
    - TwoWay binding <br>
    - TwoWay binding + Binding Adapter<br>
<br>
### Chap2. Room + Coroutine Flow<br>
    - ListAdapter + DiffUtil<br>
    - Room & Flow<br>
    - Room & Flow & ListAdapter<br>
    - Room & Flow & ListAdapter CRUD<br>
<br>
### Chap3. RoomDatabase CRUD basic<br>
    - Room CRUD<br>
<br>

### Chap4. Room Technique <br>
    - Room Miagration <br>
          1. fallbackToDestructiveMigration() : DB 기존 데이터가 날라감<br>
          2. autoMigration() 
           
        
        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
<br>
          3. TypeConverter
<br>

### Chap5. Data Saving
    - SharedPreference<br>
    - EncryptedSharedPreference: 암호화된 SharedPreference<br>

           
           implementation 'androidx.security:security-crypto:1.0.0'
    
    - DataStore<br>

### Chap6 ~ 9. Paging
    
https://developer.android.com/topic/libraries/architecture/paging/v3-overview?hl=ko<br>
```
// paging
def paging_version = "3.1.1"
implementation "androidx.paging:paging-runtime:$paging_version"

// LifecycleScope
def lifecycle_version = "2.5.1"
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"    

```

![image](https://github.com/chanho0908/inflearn_KindJectpack2/assets/84930748/f2bb3499-4fc2-4523-a3ba-6721a305bc1c)


           
        
