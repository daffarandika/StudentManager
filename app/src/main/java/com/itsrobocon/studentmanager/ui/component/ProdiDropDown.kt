package com.itsrobocon.studentmanager.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

val programs = listOf(
    "Informatika",
    "Sistem Informasi",
    "Teknik Komputer",
    "Desain Komunikasi Visual",
    "Manajemen",
    "Akuntansi"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProdiDropDown(
    selectedProgram: String,
    expanded: Boolean,
    programs: List<String>,
    onExpandedChange: (Boolean) -> Unit,
    onProgramSelected: (String) -> Unit
) {
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = onExpandedChange
    ) {
        OutlinedTextField(
            value = selectedProgram,
            onValueChange = {},
            readOnly = true,
            label = {
                Text("Program studi")
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                onExpandedChange(false)
            }
        ) {
            programs.forEach { program ->
                DropdownMenuItem(
                    text = {
                        Text(program)
                    },
                    onClick = {
                        onProgramSelected(program)
                        onExpandedChange(false)
                    }
                )
            }
        }
    }
}