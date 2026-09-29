package com.itsrobocon.studentmanager.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itsrobocon.studentmanager.ui.component.ProdiDropDown
import com.itsrobocon.studentmanager.ui.component.programs
import com.itsrobocon.studentmanager.ui.viewmodel.StudentViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpsertStudentScreen(
    modifier: Modifier = Modifier,
    nim: String? = null,
    onNavigateBack: () -> Unit = {},
    viewModel: StudentViewModel = koinViewModel(),
) {
    var name by remember { mutableStateOf("") }
    var nimInput by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }
    var dropDownExpanded by remember { mutableStateOf(value = false) }

    val isEditing = nim != null

    LaunchedEffect(nim) {
        if (nim != null) {
            val existing = viewModel.getStudentByNim(nim)
            if (existing != null) {
                name = existing.name
                nimInput = existing.nim
                department = existing.department
            }
        }
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(if (isEditing) "Edit Mahasiswa" else "Tambah Mahasiswa") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Kembali",
                        )
                    }
                },
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nama Mahasiswa") },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = nimInput,
                onValueChange = { nimInput = it },
                label = { Text("NIM") },
                enabled = !isEditing,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(8.dp))

            ProdiDropDown(
                selectedProgram = department,
                expanded = dropDownExpanded,
                programs = programs,
                onExpandedChange = { dropDownExpanded = it },
                onProgramSelected = { department = it },
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                OutlinedButton(
                    onClick = onNavigateBack,
                    modifier = Modifier.weight(1f),
                ) {
                    Text("Batal")
                }

                Button(
                    onClick = {
                        if (name.isNotBlank() && nimInput.isNotBlank() && department.isNotBlank()) {
                            viewModel.upsertStudent(name = name, nim = nimInput, department = department)
                            onNavigateBack()
                        }
                    },
                    modifier = Modifier.weight(1f),
                ) {
                    Text("Simpan")
                }
            }
        }
    }
}
