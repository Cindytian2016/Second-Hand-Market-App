import { Layout, Dropdown, Menu, Button } from "antd";
import { UserOutlined } from "@ant-design/icons";
import React from "react";
import LoginPage from "./components/LoginPage";

const { Header, Content } = Layout;

class App extends React.Component {
  state = {
    authed: false,
    asSeller: false,
  };

  componentDidMount() {
    const authToken = localStorage.getItem("authToken");
    const asSeller = localStorage.getItem("asSeller") === "true";
    this.setState({
      authed: authToken !== null,
      asSeller,
    });
  }

  handleLoginSuccess = (token, asSeller) => {
    localStorage.setItem("authToken", token);
    localStorage.setItem("asSeller", asSeller);
    this.setState({
      authed: true,
      asSeller,
    });
  };

  handleLogOut = () => {
    localStorage.removeItem("authToken");
    localStorage.removeItem("asSeller");
    this.setState({
      authed: false,
    });
  };

  renderContent = () => {
    if (!this.state.authed) {
      return <LoginPage handleLoginSuccess={this.handleLoginSuccess} />;
    }

    if (this.state.asSeller) {
      return <div>seller home page</div>;
    }

    return <div>buyer home page</div>;
  };

  userMenu = (
    <Menu>
      <Menu.Item key="logout" onClick={this.handleLogOut}>
        Log Out
      </Menu.Item>
    </Menu>
  );

  render() {
    return (
      <Layout style={{ height: "100vh" }}>
        <Header style={{ display: "flex", justifyContent: "space-between" }}>
          <div style={{ fontSize: 16, fontWeight: 600, color: "white" }}>
            Second Hand Market
          </div>
          {this.state.authed && (
            <div>
              <Dropdown trigger="click" overlay={this.userMenu}>
                <Button icon={<UserOutlined />} shape="circle" />
              </Dropdown>
            </div>
          )}
        </Header>
        <Content
          style={{ height: "calc(100% - 64px)", margin: 20, overflow: "auto" }}
        >
          {this.renderContent()}
        </Content>
      </Layout>
    );
  }
}

export default App;
