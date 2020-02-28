import React, { Component, RefObject } from 'react';
import { connect } from 'dva';
import { Button, Col, Form, Input, Row } from 'antd';
import { ConnectBoxProps, ConnectBoxState } from '@/pages/Airplane/FlightControl/ConnectBox/data';
import { FormInstance } from 'antd/lib/form';
import SockJS from 'sockjs-client';
// import Stomp from 'stomp-client';
import { Stomp } from '@stomp/stompjs';
import { CompatClient } from '@stomp/stompjs/esm5/compatibility/compat-client';

class ConnectBox extends Component<ConnectBoxProps, ConnectBoxState> {
  formRef: RefObject<FormInstance> = React.createRef();

  client: CompatClient | null = null;

  constructor(props: ConnectBoxProps) {
    super(props);
    this.state = {
      prefix: `${document.location.protocol}//`,
      value: `${document.location.host}/raspberry-pi/airplane`,
      loading: false,
    };
  }

  connect = () => {
    this.setState({ loading: true });
    const { prefix, value } = this.state;
    const url = prefix + value;
    const socket = new SockJS(url);
    const client = Stomp.over(socket);
    client.connect(
      {},
      (frame: any) => {
        console.log(`Connected:${frame}`);
        client.subscribe('/topic/callback', response => {
          const json = JSON.parse(response.body);
          console.log(json);
        });
        this.props.onConnect(client);
        this.client = client;
        this.setState({ loading: false });
      },
      (error: any) => {
        console.log(`错误${error}`);
        this.setState({ loading: false });
      },
    );
  };

  disconnect = () => {
    if (this.client != null) {
      this.client.disconnect(() => {
        this.client = null;
      });
    }
  };

  onFormChange = (values: any) => {
    this.setState({ value: values.url });
  };

  render() {
    const { prefix, value, loading } = this.state;
    return (
      <Form ref={this.formRef} onValuesChange={this.onFormChange}>
        <Row gutter={8}>
          <Col xs={20}>
            <Form.Item name="url">
              <Input addonBefore={prefix} defaultValue={value} />
            </Form.Item>
          </Col>
          {this.client == null && (
            <Col xs={2}>
              <Button type="primary" onClick={this.connect} loading={loading}>
                连接服务器
              </Button>
            </Col>
          )}
          {this.client != null && (
            <Col xs={2}>
              <Button type="danger" onClick={this.disconnect}>
                断开连接
              </Button>
            </Col>
          )}
        </Row>
      </Form>
    );
  }
}

export default connect(() => ({}))(ConnectBox);
