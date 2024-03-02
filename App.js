import { Layout, Row, Col, Card, Button, Menu } from 'antd';
import React from 'react';
import { HeartFilled, HeartOutlined } from '@ant-design/icons';

const { Header, Content } = Layout;

function App() {

  // initial data for testing
  const [items, setItems] = React.useState([]);
  const [favoriteItems, setFavoriteItems] = React.useState([]);
  const [menuKey, setMenuKey] = React.useState('1');

  React.useEffect(() => {
    // fetch to get the data
    fetch('http://localhost:8080/api/items')
      .then(response => response.json())
      .then(data => {
        setItems(data);
      });
    fetch('http://localhost:8080/api/favorite/1')
      .then(response => response.json())
      .then(data => {
        setFavoriteItems(data);
      });
  }, []);

  const data = React.useMemo(() => {

    if (menuKey === '1') {
      return items.map(item => {
        const favorite = favoriteItems.find(favoriteItem => favoriteItem.item.id === item.id);
        return {
          ...item,
          favorite: !!favorite
        }
      });
    } else {
      return items.filter(item => {
        const favorite = favoriteItems.find(favoriteItem => favoriteItem.item.id === item.id);
        return !!favorite;
      }).map(item => {
        const favorite = favoriteItems.find(favoriteItem => favoriteItem.item.id === item.id);
        return {
          ...item,
          favorite: !!favorite
        }
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
      const favoriteIndex = newFavoriteItems.findIndex(favoriteItem => favoriteItem.item.id === newData[index].id);
      newFavoriteItems.splice(favoriteIndex, 1);
    }
    setFavoriteItems(newFavoriteItems);
    if (newData[index].favorite) {
      // fetch to update the favorite status
      fetch(`http://localhost:8080/api/favorite?userId=1&itemId=${newData[index].id}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        }
      });
    } else {
      fetch(`http://localhost:8080/api/favorite/1/${newData[index].id}`, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json'
        }
      });
    }
  };

  return (
    <Layout>
      <Header style={{ display: 'flex', alignItems: 'center' }}>
        <div style={{ color: 'white', marginRight: '20px' }}>Markets</div>
        <Menu
          theme="dark"
          mode="horizontal"
          defaultSelectedKeys={['1']}
          items={[{ key: 1, label: 'Home' }, { key: 2, label: 'Favorites' }]}
          style={{ flex: 1, minWidth: 0 }}
          onSelect={(item) => {
            setMenuKey(item.key);
          }}
        />
      </Header>
      <Content style={{ height: 'calc(100vh - 64px)', padding: 24, overflow: 'auto', display: 'flex', flexDirection: 'row', flexWrap: 'wrap' }}>
        {
          Array.isArray(data) && data.length > 0
            ? new Array(data.length).fill(0).map((_, index) => (
              <Card key={index} style={{ width: 350, margin: 24 }}
                title={data[index].name}
                cover={<img alt="example" src="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png" />}
                extra={<Button type="text" onClick={toggleFavorite(index)}>
                  {
                    data[index].favorite ? <HeartFilled style={{ color: 'red' }}/> : <HeartOutlined />
                  }
                  
                </Button>}
              >
                <Row>
                  <Col span={24}>
                    <p>{data[index].description}</p>
                  </Col>
                </Row>
                <Row>
                  <Col span={24}>
                    <p>Price: ${data[index].price}</p>
                  </Col>
                </Row>
              </Card>
            ))
            : <div>No data</div>
        }
      </Content>
    </Layout>
  );
}

export default App;
