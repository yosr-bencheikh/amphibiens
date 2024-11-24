package com.example.amphibians.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.amphibians.model.Amphibian

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibianListScreen(viewModel: AmphibianViewModel) {
    val amphibians = viewModel.amphibians.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Amphibians") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(amphibians.size) { index ->
                AmphibianCard(amphibian = amphibians[index])
            }
        }
    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(amphibian.name, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(amphibian.type, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = rememberImagePainter(amphibian.imgSrc),
                contentDescription = amphibian.name,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(amphibian.description, style = MaterialTheme.typography.bodySmall)
        }
    }
}
