import { Row, Col, Card, Button } from "antd";
import { HeartFilled, HeartOutlined } from "@ant-design/icons";

export default function Cards({ data, index, toggleFavorite }) {
  return (
    <Card
      key={index}
      style={{ width: 350, margin: 24 }}
      title={data[index].name}
      cover={
        <img
          alt="example"
          src="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png"
        />
      }
      extra={
        <Button type="text" onClick={toggleFavorite(index)}>
          {data[index].favorite ? (
            <HeartFilled style={{ color: "red" }} />
          ) : (
            <HeartOutlined />
          )}
        </Button>
      }
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
  );
}
