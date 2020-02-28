import React, { Component } from 'react';
import { connect } from 'dva';
import { Form } from '@ant-design/compatible';
import { Button, Col, Input, Row } from 'antd';
import { ConnectBoxProps, ConnectBoxState } from '@/pages/Airplane/FlightControl/ConnectBox/data';

class ConnectBox extends Component<ConnectBoxProps, ConnectBoxState> {
  constructor(props: ConnectBoxProps) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <Row gutter={8}>
        <Col xs={20}>
          <Input
            addonBefore="http://"
            defaultValue={`${document.location.host}/raspberry-pi/airplane`}
          />
        </Col>
        <Col xs={2}>
          <Button type="primary">连接服务器</Button>
        </Col>
        <Col xs={2}>
          <Button type="danger">断开连接</Button>
        </Col>
      </Row>
    );
  }
}

export default connect(() => ({}))(Form.create<ConnectBoxProps>()(ConnectBox));
