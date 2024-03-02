import { Layout } from "antd";
import React from "react";
import Headers from "./components/Header";
import Cards from "./components/Cards";
import {
  addFavoriteItem,
  getItems,
  getFavoriteItems,
  removeFavorite,
} from "./utils";
const { Content } = Layout;
function App() {
  // initial data for testing
  const [items, setItems] = React.useState([]);
  const [favoriteItems, setFavoriteItems] = React.useState([]);
  const [menuKey, setMenuKey] = React.useState("1");

  React.useEffect(() => {
    // fetch to get the data
    getItems().then((data) => {
      setItems(data);
    });
    getFavoriteItems(1).then((data) => {
      setFavoriteItems(data);
    });
  }, []);

  const data = React.useMemo(() => {
    if (menuKey === "1") {
      return items.map((item) => {
        const favorite = favoriteItems.find(
          (favoriteItem) => favoriteItem.item.id === item.id
        );
        return {
          ...item,
          favorite: !!favorite,
        };
      });
    } else {
      return items
        .filter((item) => {
          const favorite = favoriteItems.find(
            (favoriteItem) => favoriteItem.item.id === item.id
          );
          return !!favorite;
        })
        .map((item) => {
          const favorite = favoriteItems.find(
            (favoriteItem) => favoriteItem.item.id === item.id
          );
          return {
            ...item,
            favorite: !!favorite,
          };
        });
    }
  }, [menuKey, items, favoriteItems]);

  const toggleFavorite = (index) => () => {
    const newData = [...data];
    newData[index].favorite = !newData[index].favorite;
    const newFavoriteItems = [...favoriteItems];
    if (newData[index].favorite && newData[index].id) {
      newFavoriteItems.push({ userId: 1, item: { id: newData[index].id } });
    } else {
      const favoriteIndex = newFavoriteItems.findIndex(
        (favoriteItem) => favoriteItem.item.id === newData[index].id
      );
      newFavoriteItems.splice(favoriteIndex, 1);
    }
    setFavoriteItems(newFavoriteItems);
    if (newData[index].favorite) {
      // fetch to update the favorite status
      addFavoriteItem(1, newData[index].id);
    } else {
      // fetch to remove the favorite status
      removeFavorite(1, newData[index].id);
    }
  };

  return (
    <Layout>
      <Headers
        onSelect={(item) => {
          setMenuKey(item.key);
        }}
      />
      <Content
        style={{
          height: "calc(100vh - 64px)",
          padding: 24,
          overflow: "auto",
          display: "flex",
          flexDirection: "row",
          flexWrap: "wrap",
        }}
      >
        {Array.isArray(data) && data.length > 0 ? (
          new Array(data.length)
            .fill(0)
            .map((_, index) => (
              <Cards
                data={data}
                index={index}
                toggleFavorite={toggleFavorite}
              />
            ))
        ) : (
          <div>No data</div>
        )}
      </Content>
    </Layout>
  );
}

export default App;
