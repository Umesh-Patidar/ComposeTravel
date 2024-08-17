package com.umesh.composetravel.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composetravel.ui.theme.LightGrey
import com.umesh.composetravel.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(onSearchInputValue: () -> Unit) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier.padding(5.dp)
            .fillMaxWidth()
            .border(2.dp, LightGrey, RoundedCornerShape(20.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            OutlinedTextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true,
                placeholder = { Text("Search places") }
            )
            Spacer(
                modifier = Modifier.padding(end = 10.dp)
                    .height(24.dp)
                    .width(1.dp)
                    .background(Color.Gray)
            )
            Icon(
                painter = painterResource(id = R.drawable.icon_setting), // Replace with your icon resource
                contentDescription = "Icon",
                modifier = Modifier
                    .padding(start = 20.dp, end = 25.dp)
                    .size(24.dp),
                tint = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomSearchBar() {
    CustomSearchBar {}
}
