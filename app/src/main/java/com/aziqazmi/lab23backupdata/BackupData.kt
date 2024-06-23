package com.aziqazmi.lab23backupdata

import android.app.backup.BackupAgentHelper
import android.app.backup.SharedPreferencesBackupHelper

class BackupData: BackupAgentHelper() {

    // JEnis data type untuk mencipta constant
    // Declare name fail, key atau nama columh
    companion object {
        val PREFS_TEST = "messages" // Nama shared preference (file name db)
        val MY_PREFS_BACKUP_KEY =
            "messagesbckp" // Nama untuk disimpan di dalam backup (file name backup)
    }

    override fun onCreate()
    {
        super.onCreate()

        var helper = SharedPreferencesBackupHelper(this, PREFS_TEST)
        addHelper(MY_PREFS_BACKUP_KEY, helper)

    }
}