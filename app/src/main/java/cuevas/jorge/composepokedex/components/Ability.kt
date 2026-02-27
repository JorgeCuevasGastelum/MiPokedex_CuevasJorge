package cuevas.jorge.composepokedex.components

import android.graphics.fonts.Font
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import cuevas.jorge.composepokedex.ui.theme.Red

@Composable
fun Ability(type: String, label: String, value: String){
    if(type=="row"){
        Row{
            Label(label)
            Text(value)
        }
    }else{
        Column(){
            Label(label)
            Text(value)
        }
    }
}


@Composable
fun Label(text: String){
    Text(text, color = Red, fontWeight = FontWeight.Bold)
}