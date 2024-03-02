import { Menu, Layout } from "antd";
const { Header } = Layout;

export default function Headers({ onSelect }) {
  return (
    <Header style={{ display: "flex", alignItems: "center" }}>
      <div style={{ color: "white", marginRight: "20px" }}>Markets</div>
      <Menu
        theme="dark"
        mode="horizontal"
        defaultSelectedKeys={["1"]}
        items={[
          { key: 1, label: "Home" },
          { key: 2, label: "Favorites" },
        ]}
        style={{ flex: 1, minWidth: 0 }}
        onSelect={onSelect}
      />
    </Header>
  );
}
