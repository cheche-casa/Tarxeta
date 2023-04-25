package com.example.tarxeta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarxeta.ui.theme.TarxetaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarxetaTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    PintaTarxeta()
                }
            }
        }
    }
}

@Composable
fun PintaTarxeta(modifier: Modifier = Modifier){
    val listaColores = listOf(colorResource(R.color.fondo_0),
        colorResource(R.color.fondo_1),
        colorResource(R.color.fondo_2))

    Box (modifier = Modifier
        .background(Brush.verticalGradient(listaColores))
    ) {
        Box (modifier = Modifier
            .padding(top = 170.dp)
        ) {
            Box (modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .size(100.dp),
                        painter = painterResource(R.drawable.android_logo),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = stringResource(R.string.Nome),
                        color = colorResource(R.color.gris_claro),
                        fontSize = 40.sp,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp)
                    )
                    Text(
                        text = stringResource(R.string.Titulo),
                        color = colorResource(R.color.teal_700),
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }
            }
            Box (modifier = Modifier
                .padding(bottom = 50.dp)
                .fillMaxSize()
            ){
                Column(
                    modifier = modifier
                        .padding(top = 29.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.Start
                ) {
                    Divider(color = Color.Gray, thickness = 1.dp)
                    Contactos(painterResource(R.drawable.baseline_email_white_18dp),
                        stringResource(R.string.Correo))
                    Divider(color = Color.Gray, thickness = 1.dp)
                    Contactos(painterResource(R.drawable.baseline_phone_white_18dp),
                        stringResource(R.string.TLF))
                    Divider(color = Color.Gray, thickness = 1.dp)
                    Contactos(painterResource(R.drawable.baseline_web_stories_white_18dp),
                        stringResource(R.string.Web))
                }
            }
        }
    }
}

@Composable
fun Contactos(
    Icono: Painter,
    Texto: String
) {
    Row() {
        Image(modifier = Modifier
                .padding(top = 5.dp,start = 40.dp)
                .size(28.dp),
            painter = Icono,
            contentDescription = null,
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(colorResource(R.color.teal_700))
        )
        Text(modifier = Modifier
            .padding(top = 5.dp,start = 15.dp),
            text = Texto,
            color = colorResource(R.color.gris_claro),
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TarxetaTheme {
        PintaTarxeta()
    }
}