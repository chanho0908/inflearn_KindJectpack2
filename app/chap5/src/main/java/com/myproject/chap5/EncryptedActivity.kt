package com.myproject.chap5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.myproject.chap5.databinding.ActivityEncryptedBinding

class EncryptedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEncryptedBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEncryptedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        val sharedPreferences = EncryptedSharedPreferences.create(
            "shared_pref_fileName",
            masterKeyAlias,
            this,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        binding.save1.setOnClickListener {
            val text = binding.editText1.text.toString()

            with(sharedPreferences.edit()){
                putString("valueTest", text)
                apply()
            }
        }

        binding.read1.setOnClickListener {
            val sharedVal = sharedPreferences.getString("valueTest", "defaultValue")
            binding.readText1.text = sharedVal

        }
    }
}