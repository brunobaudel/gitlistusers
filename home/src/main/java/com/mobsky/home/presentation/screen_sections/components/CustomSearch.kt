package com.mobsky.home.presentation.screen_sections.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchableTopBar(
    currentSearchText: String,
    onSearchTextChanged: ((String) -> Unit) = {},
    onSearchDeactivated: () -> Unit = {},
    onSearchDispatched: (String) -> Unit = {},
    onSearchIconClicked: () -> Unit = {}
) {

    val isShowingSearchField = remember { mutableStateOf(false) }

    if (isShowingSearchField.value) {
        SearchTopBar(
            currentSearchText = "",
            onSearchTextChanged = onSearchTextChanged,
            onSearchDeactivated = {
                onSearchDeactivated()
                isShowingSearchField.value = false
            },
            onSearchDispatched = onSearchDispatched
        )
    } else {
        HomeTopBar(
            topBarNameId = currentSearchText,
            onSearchIconClicked = {
                onSearchIconClicked()
                isShowingSearchField.value = true
            }
        )
    }
}

@Composable
fun SearchTopBar(
    currentSearchText: String,
    onSearchTextChanged: (String) -> Unit,
    onSearchDeactivated: () -> Unit,
    onSearchDispatched: (String) -> Unit
) {

    val currentSearchRemember = remember {
        mutableStateOf(currentSearchText)
    }

    val currentSearchRememberValue = currentSearchRemember.value

    Surface(
        modifier = Modifier.run {
            fillMaxWidth()
                .height(56.dp)
        },
        shadowElevation = AppBarDefaults.TopAppBarElevation
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = currentSearchRemember.value,
            onValueChange = {
                currentSearchRemember.value = it
                onSearchTextChanged(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "Digite aqui...",
                    color = Color.White
                )
            },
            textStyle = TextStyle(fontSize = MaterialTheme.typography.bodyLarge.fontSize),
            singleLine = true,
            leadingIcon = { SearchLeadingIcon{
                onSearchDispatched(currentSearchRememberValue)
            } },
            trailingIcon = {
                SearchTrailingIcon {
                    if (currentSearchRememberValue.isNotEmpty()) {
                        currentSearchRemember.value = ""
                        onSearchTextChanged("")
                    } else onSearchDeactivated()
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onSearchDispatched(currentSearchRememberValue) }),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black.copy(alpha = ContentAlpha.medium)
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(topBarNameId: String = "", onSearchIconClicked: () -> Unit) {
    Surface(shadowElevation = AppBarDefaults.TopAppBarElevation) {
        TopAppBar(
            title = { Text(text = topBarNameId) },
            actions = { SearchIcon(action = onSearchIconClicked) }
        )
    }
}

@Composable
fun SearchIcon(action: () -> Unit = {}) {
    DefaultIcon(
        searchIcon = Icons.Filled.Search,
        contentDescription = "Search Icon",
        onIconClickAction = action
    )
}

@Composable
fun SearchLeadingIcon(action: () -> Unit = {}) {
    DefaultIcon(
        modifier = Modifier.alpha(ContentAlpha.medium),
        onIconClickAction = action
    )
}

@Composable
fun SearchTrailingIcon(action: () -> Unit = {}) {
    DefaultIcon(
        searchIcon = Icons.Default.Close,
        contentDescription = "Deactivate Search Icon",
        onIconClickAction = action
    )
}

@Composable
fun DefaultIcon(
    modifier: Modifier = Modifier,
    searchIcon: ImageVector = Icons.Default.Search,
    contentDescription: String = "Magnifier Search Icon",
    onIconClickAction: () -> Unit = {}
) {
    IconButton(
        modifier = modifier,
        onClick = onIconClickAction
    ) {
        Icon(
            imageVector = searchIcon,
            contentDescription = contentDescription,
        )
    }
}

@Composable
@Preview
fun HomeTopBarPreview() {
    HomeTopBar("", onSearchIconClicked = {})
}

@Composable
@Preview
fun SearchTopBarPreview() {
    SearchTopBar(
        currentSearchText = "Texto de busca",
        onSearchTextChanged = {},
        onSearchDeactivated = {},
        onSearchDispatched = {}
    )
}