package com.itsrobocon.studentmanager.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.TransitEnterexit
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentTopBar(
    menuExpanded: Boolean,
    onMenuExpandedChange: (Boolean) -> Unit = {},
    onRefresh: () -> Unit = {},
    onAbout: () -> Unit = {},
    onExit: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text("Student Management")
        },
        actions = {
            Box {
                IconButton(
                    onClick = {
                        onMenuExpandedChange(true)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Menu"
                    )
                }

                DropdownMenu(
                    expanded = menuExpanded,
                    onDismissRequest = {
                        onMenuExpandedChange(false)
                    }
                ) {
                    DropdownMenuItem(
                        text = {
                            Text("Refresh")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null
                            )
                        },
                        onClick = {
                            onMenuExpandedChange(false)
                            onRefresh()
                        }
                    )

                    DropdownMenuItem(
                        text = {
                            Text("Tentang Aplikasi")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = null
                            )
                        },
                        onClick = {
                            onMenuExpandedChange(false)
                            onAbout()
                        }
                    )

                    DropdownMenuItem(
                        text = {
                            Text("Keluar")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.TransitEnterexit,
                                contentDescription = null
                            )
                        },
                        onClick = {
                            onMenuExpandedChange(false)
                            onExit()
                        }
                    )
                }
            }
        }
    )
}