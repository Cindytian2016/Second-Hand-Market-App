export function getItems() {
  return fetch("http://localhost:8080/api/items").then((res) => res.json());
}

export function getFavoriteItems(userId) {
  return fetch(`http://localhost:8080/api/favorite/${userId}`).then((res) =>
    res.json()
  );
}

export function addFavoriteItem(userId, itemId) {
  return fetch(
    `http://localhost:8080/api/favorite?userId=${userId}&itemId=${itemId}`,
    {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    }
  );
}

export function removeFavorite(userId, itemId) {
  return fetch(`http://localhost:8080/api/favorite/${userId}/${itemId}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  });
}
