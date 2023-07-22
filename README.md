# 인프런 친절한 JETPACK 개론


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

<br>

### Chap4. Room Technique <br>

    # Room Miagration <br>
           - fallbackToDestructiveMigration() : DB 기존 데이터가 날라감<br>
           - autoMigration() 
           
        
        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
<br>
          - TypeConverter
<br>

### Chap5. Data Saving
    - SharedPreference<br>
    - EncryptedSharedPreference: 암호화된 SharedPreference<br>

           
           implementation 'androidx.security:security-crypto:1.0.0'
    
    - DataStore<br>

           
        
