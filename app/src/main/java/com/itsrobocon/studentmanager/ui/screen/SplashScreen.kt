package com.itsrobocon.studentmanager.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsrobocon.studentmanager.ui.component.GraduationCap
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onChangePage: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        LaunchedEffect(Unit) {
            delay(500L)
            onChangePage()
        }
        Icon(GraduationCap, "graduation cap", modifier.size(88.dp))
        Spacer(Modifier.size(16.dp))
        Text(
            text = "Student Manager",
            fontSize = 36.sp
        )
        Spacer(Modifier.size(16.dp))
        Text(
            text = "Kelola data mahasiswa dengan mudah",
            fontSize = 16.sp
        )
        Spacer(Modifier.size(16.dp))
        CircularProgressIndicator(
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SplashScreenPreview() {

}