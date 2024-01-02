package com.example.picgallery.ui.components.userlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.picgallery.domain.model.User

@Composable
fun itemUserCard(user: User,onItemClicked: (user: User) -> Unit){
Card(
    modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(16.dp))
        .clickable(onClick = { onItemClicked(user) }),
         elevation = 0.dp,
         backgroundColor = MaterialTheme.colors.surface
) {
  Row(
      modifier = Modifier.
                 fillMaxWidth()
                 .padding(16.dp)
  ) {
      val image: Painter = rememberAsyncImagePainter("https://picsum.photos/200/300")
      Image(
          modifier = Modifier
              .size(80.dp, 80.dp)
              .clip(CircleShape),
          painter = image,
          alignment = Alignment.CenterStart,
          contentDescription = "",
          contentScale = ContentScale.Crop
      )
      Spacer(modifier = Modifier.width(16.dp))
      Column(modifier = Modifier.align(Alignment.CenterVertically)) {
          Text(
              text = user.name,
              modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
              color = Color.Black,
              fontWeight = FontWeight.Bold,
              style = MaterialTheme.typography.subtitle1
          )
          Spacer(modifier = Modifier.height(8.dp))

          Text(
              text = user.email,
              modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
              color = Color.Black,
              style = MaterialTheme.typography.caption
          )

      }
  }
}
}