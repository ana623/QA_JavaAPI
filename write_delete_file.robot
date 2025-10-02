<?xml version="1.0" encoding="UTF-8" ?>
<object class="Robot2" serializationversion="2">
  <prologue>
    <saved-by-versions>
      <version>11.5.0.7</version>
    </saved-by-versions>
    <file-type>robot2</file-type>
    <comment/>
    <icon/>
    <tags/>
    <typed-variables/>
    <parameters/>
    <requires-simple-input>false</requires-simple-input>
    <return-variables/>
    <store-in-database-variables/>
    <referenced-types/>
    <triggers/>
    <sub-robots/>
    <device-mappings/>
  </prologue>
  <body>{
  "meta":{
    "className":"Robot",
    "version":9
  },
  "gizmo":{
    "parameters": [],
    "hubMappings": [],
    "databaseMappings": [],
    "returnTypes": [],
    "treeModes": [],
    "types": [],
    "cacheLock": {
      "meta":{
        "className":"CacheLock",
        "version":0
      },
      "gizmo":{
        
      }
    },
    "variables": [],
    "configurations": {
      "meta":{
        "className":"Configuration",
        "version":0
      },
      "gizmo":{
        "comment": {
          "meta":{
            "className":"Comment",
            "version":0
          },
          "gizmo":{
            "comment": { "string": "" }
          }
        },
        "tags": [],
        "humanProcessingTime": [],
        "icon": []
      }
    },
    "block": {
      "meta":{
        "className":"Block",
        "version":2
      },
      "gizmo":{
        "steps": [{
          "meta":{
            "className":"WriteFileStep",
            "version":2
          },
          "gizmo":{
            "name": {
              "meta":{
                "className":"StepName",
                "version":0
              },
              "gizmo":{
                "customName": { "string": "" }
              }
            },
            "comment": {
              "meta":{
                "className":"Comment",
                "version":0
              },
              "gizmo":{
                "comment": { "string": "" }
              }
            },
            "finder": {
              "meta":{
                "className":"DeviceFinderWithName",
                "version":3
              },
              "gizmo":{
                "name": {
                  "meta":{
                    "className":"FinderName",
                    "version":0
                  },
                  "gizmo":{
                    "id": { "string": "" }
                  }
                },
                "finder": {
                  "meta":{
                    "className":"DeviceReference",
                    "version":0
                  },
                  "gizmo":{
                    "reference": {
                      "meta":{
                        "className":"NamedFinderReference",
                        "version":0
                      },
                      "gizmo":{
                        "id": { "string": "local" }
                      }
                    }
                  }
                },
                "comment": {
                  "meta":{
                    "className":"Comment",
                    "version":0
                  },
                  "gizmo":{
                    "comment": { "string": "" }
                  }
                }
              }
            },
            "contents": {
              "meta":{
                "className":"Expression",
                "version":1
              },
              "gizmo":{
                "text": { "string": "=\"12245756anahsjdkdl\".binary(\"utf8\")" },
                "comment": {
                  "meta":{
                    "className":"Comment",
                    "version":0
                  },
                  "gizmo":{
                    "comment": { "string": "" }
                  }
                }
              }
            },
            "file": {
              "meta":{
                "className":"RfsFileReference",
                "version":0
              },
              "gizmo":{
                "file": {
                  "meta":{
                    "className":"Expression",
                    "version":1
                  },
                  "gizmo":{
                    "text": { "string": "rfs/ABCD.txt" },
                    "comment": {
                      "meta":{
                        "className":"Comment",
                        "version":0
                      },
                      "gizmo":{
                        "comment": { "string": "" }
                      }
                    }
                  }
                }
              }
            }
          }
        },
        {
          "meta":{
            "className":"GuardedChoiceStep",
            "version":1
          },
          "gizmo":{
            "name": {
              "meta":{
                "className":"StepName",
                "version":0
              },
              "gizmo":{
                "customName": { "string": "" }
              }
            },
            "comment": {
              "meta":{
                "className":"Comment",
                "version":0
              },
              "gizmo":{
                "comment": { "string": "" }
              }
            },
            "branches": [{
              "meta":{
                "className":"GuardAndBlock",
                "version":4
              },
              "gizmo":{
                "guard": {
                  "meta":{
                    "className":"TimeOutGuard",
                    "version":0
                  },
                  "gizmo":{
                    "seconds": {
                      "meta":{
                        "className":"Expression",
                        "version":1
                      },
                      "gizmo":{
                        "text": { "string": "2" },
                        "comment": {
                          "meta":{
                            "className":"Comment",
                            "version":0
                          },
                          "gizmo":{
                            "comment": { "string": "" }
                          }
                        }
                      }
                    }
                  }
                },
                "block": {
                  "meta":{
                    "className":"Block",
                    "version":2
                  },
                  "gizmo":{
                    "steps": []
                  }
                },
                "comment": {
                  "meta":{
                    "className":"Comment",
                    "version":0
                  },
                  "gizmo":{
                    "comment": { "string": "" }
                  }
                }
              }
            }]
          }
        },
        {
          "meta":{
            "className":"FilesystemActionStep",
            "version":0
          },
          "gizmo":{
            "name": {
              "meta":{
                "className":"StepName",
                "version":0
              },
              "gizmo":{
                "customName": { "string": "Delete File" }
              }
            },
            "comment": {
              "meta":{
                "className":"Comment",
                "version":0
              },
              "gizmo":{
                "comment": { "string": "" }
              }
            },
            "finder": {
              "meta":{
                "className":"DeviceFinderWithName",
                "version":3
              },
              "gizmo":{
                "name": {
                  "meta":{
                    "className":"FinderName",
                    "version":0
                  },
                  "gizmo":{
                    "id": { "string": "" }
                  }
                },
                "finder": {
                  "meta":{
                    "className":"DeviceReference",
                    "version":0
                  },
                  "gizmo":{
                    "reference": {
                      "meta":{
                        "className":"NamedFinderReference",
                        "version":0
                      },
                      "gizmo":{
                        "id": { "string": "local" }
                      }
                    }
                  }
                },
                "comment": {
                  "meta":{
                    "className":"Comment",
                    "version":0
                  },
                  "gizmo":{
                    "comment": { "string": "" }
                  }
                }
              }
            },
            "config": {
              "meta":{
                "className":"ActionStepConfig",
                "version":0
              },
              "gizmo":{
                "properties": {
                  "meta":{
                    "className":"RecordDasValue",
                    "version":0
                  },
                  "gizmo":{
                    "values": [{
                      "meta":{
                        "className":"DasFieldValue",
                        "version":0
                      },
                      "gizmo":{
                        "name": { "string": "Action" },
                        "value": {
                          "meta":{
                            "className":"UnionDasValue",
                            "version":0
                          },
                          "gizmo":{
                            "id": { "string": "Delete File" },
                            "value": {
                              "meta":{
                                "className":"MethodDasValue",
                                "version":0
                              },
                              "gizmo":{
                                "arguments": {
                                  "meta":{
                                    "className":"RecordDasValue",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "values": [{
                                      "meta":{
                                        "className":"DasFieldValue",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "name": { "string": "File Access" },
                                        "value": {
                                          "meta":{
                                            "className":"EnumDasValue",
                                            "version":0
                                          },
                                          "gizmo":{
                                            "id": { "string": "Via RFS" }
                                          }
                                        }
                                      }
                                    },
                                    {
                                      "meta":{
                                        "className":"DasFieldValue",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "name": { "string": "File" },
                                        "value": {
                                          "meta":{
                                            "className":"ExpressionDasValue",
                                            "version":0
                                          },
                                          "gizmo":{
                                            "expression": {
                                              "meta":{
                                                "className":"Expression",
                                                "version":1
                                              },
                                              "gizmo":{
                                                "text": { "string": "rfs/ABCD.txt" },
                                                "comment": {
                                                  "meta":{
                                                    "className":"Comment",
                                                    "version":0
                                                  },
                                                  "gizmo":{
                                                    "comment": { "string": "" }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }]
                                  }
                                },
                                "returns": {
                                  "meta":{
                                    "className":"RecordDasValue",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "values": []
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }]
                  }
                },
                "metadata": {
                  "meta":{
                    "className":"RecordDasType",
                    "version":0
                  },
                  "gizmo":{
                    "fields": [{
                      "meta":{
                        "className":"DasField",
                        "version":2
                      },
                      "gizmo":{
                        "name": { "string": "Action" },
                        "localizationKey": { "string": "Signature.fsops.device.kActionTitle" },
                        "optional": { "boolean": "false" },
                        "collapsible": { "boolean": "false" },
                        "typeDefinition": {
                          "meta":{
                            "className":"UnionDasType",
                            "version":0
                          },
                          "gizmo":{
                            "defaultVariantId": { "string": "" },
                            "variants": [{
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "List Directory" },
                                "localizationKey": { "string": "Signature.fsops.device.kList" },
                                "id": { "string": "List Directory" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "File Access" },
                                            "localizationKey": { "string": "Signature.fsops.device.kFileAccess" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"EnumDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultMemberId": { "string": "Direct Access" },
                                                "enumMembers": [{
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Direct Access" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kDirectAccess" },
                                                    "id": { "string": "Direct Access" }
                                                  }
                                                },
                                                {
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Via RFS" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kViaRFS" },
                                                    "id": { "string": "Via RFS" }
                                                  }
                                                }],
                                                "showAsRadioButton": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Directory" },
                                            "localizationKey": { "string": "Signature.fsops.device.kDirectory" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Application Name" },
                                            "localizationKey": { "string": "Signature.fsops.device.kApplicationName" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": []
                                      }
                                    }
                                  }
                                }
                              }
                            },
                            {
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "Delete File" },
                                "localizationKey": { "string": "Signature.fsops.device.kDeleteFile" },
                                "id": { "string": "Delete File" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "File Access" },
                                            "localizationKey": { "string": "Signature.fsops.device.kFileAccess" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"EnumDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultMemberId": { "string": "Direct Access" },
                                                "enumMembers": [{
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Direct Access" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kDirectAccess" },
                                                    "id": { "string": "Direct Access" }
                                                  }
                                                },
                                                {
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Via RFS" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kViaRFS" },
                                                    "id": { "string": "Via RFS" }
                                                  }
                                                }],
                                                "showAsRadioButton": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "File" },
                                            "localizationKey": { "string": "Signature.fsops.device.kFile" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": []
                                      }
                                    }
                                  }
                                }
                              }
                            },
                            {
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "Create Directory" },
                                "localizationKey": { "string": "Signature.fsops.device.kCreateDirectory" },
                                "id": { "string": "Create Directory" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "File Access" },
                                            "localizationKey": { "string": "Signature.fsops.device.kFileAccess" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"EnumDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultMemberId": { "string": "Direct Access" },
                                                "enumMembers": [{
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Direct Access" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kDirectAccess" },
                                                    "id": { "string": "Direct Access" }
                                                  }
                                                },
                                                {
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Via RFS" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kViaRFS" },
                                                    "id": { "string": "Via RFS" }
                                                  }
                                                }],
                                                "showAsRadioButton": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Directory" },
                                            "localizationKey": { "string": "Signature.fsops.device.kDirectory" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": []
                                      }
                                    }
                                  }
                                }
                              }
                            },
                            {
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "Delete Directory" },
                                "localizationKey": { "string": "Signature.fsops.device.kDeleteDirectory" },
                                "id": { "string": "Delete Directory" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "File Access" },
                                            "localizationKey": { "string": "Signature.fsops.device.kFileAccess" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"EnumDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultMemberId": { "string": "Direct Access" },
                                                "enumMembers": [{
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Direct Access" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kDirectAccess" },
                                                    "id": { "string": "Direct Access" }
                                                  }
                                                },
                                                {
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Via RFS" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kViaRFS" },
                                                    "id": { "string": "Via RFS" }
                                                  }
                                                }],
                                                "showAsRadioButton": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Directory" },
                                            "localizationKey": { "string": "Signature.fsops.device.kDirectory" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": []
                                      }
                                    }
                                  }
                                }
                              }
                            },
                            {
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "Exists" },
                                "localizationKey": { "string": "Signature.fsops.device.kExists" },
                                "id": { "string": "Exists" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "File Access" },
                                            "localizationKey": { "string": "Signature.fsops.device.kFileAccess" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"EnumDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultMemberId": { "string": "Direct Access" },
                                                "enumMembers": [{
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Direct Access" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kDirectAccess" },
                                                    "id": { "string": "Direct Access" }
                                                  }
                                                },
                                                {
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Via RFS" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kViaRFS" },
                                                    "id": { "string": "Via RFS" }
                                                  }
                                                }],
                                                "showAsRadioButton": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Item" },
                                            "localizationKey": { "string": "Signature.fsops.device.kItem" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Result" },
                                            "localizationKey": { "string": "Signature.fsops.device.kResult" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"BoolDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "boolean": "false" },
                                                "evaluateAtRuntime": { "boolean": "true" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    }
                                  }
                                }
                              }
                            },
                            {
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "Lock Status" },
                                "localizationKey": { "string": "Signature.fsops.device.kLockStatus" },
                                "id": { "string": "Lock Status" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "File Access" },
                                            "localizationKey": { "string": "Signature.fsops.device.kFileAccess" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"EnumDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultMemberId": { "string": "Direct Access" },
                                                "enumMembers": [{
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Direct Access" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kDirectAccess" },
                                                    "id": { "string": "Direct Access" }
                                                  }
                                                },
                                                {
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Via RFS" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kViaRFS" },
                                                    "id": { "string": "Via RFS" }
                                                  }
                                                }],
                                                "showAsRadioButton": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Item" },
                                            "localizationKey": { "string": "Signature.fsops.device.kItem" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Result" },
                                            "localizationKey": { "string": "Signature.fsops.device.kResult" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"IntDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "int": "0" },
                                                "minValue": { "int": "-2147483648" },
                                                "maxValue": { "int": "2147483647" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    }
                                  }
                                }
                              }
                            },
                            {
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "Copy File" },
                                "localizationKey": { "string": "Signature.fsops.device.kCopyFile" },
                                "id": { "string": "Copy File" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Source Access" },
                                            "localizationKey": { "string": "Signature.fsops.device.kSourceAccess" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"EnumDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultMemberId": { "string": "Direct Access" },
                                                "enumMembers": [{
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Direct Access" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kDirectAccess" },
                                                    "id": { "string": "Direct Access" }
                                                  }
                                                },
                                                {
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Via RFS" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kViaRFS" },
                                                    "id": { "string": "Via RFS" }
                                                  }
                                                }],
                                                "showAsRadioButton": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Source" },
                                            "localizationKey": { "string": "Signature.fsops.device.kSource" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Destination Access" },
                                            "localizationKey": { "string": "Signature.fsops.device.kDestinationAccess" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"EnumDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultMemberId": { "string": "Direct Access" },
                                                "enumMembers": [{
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Direct Access" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kDirectAccess" },
                                                    "id": { "string": "Direct Access" }
                                                  }
                                                },
                                                {
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Via RFS" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kViaRFS" },
                                                    "id": { "string": "Via RFS" }
                                                  }
                                                }],
                                                "showAsRadioButton": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Destination" },
                                            "localizationKey": { "string": "Signature.fsops.device.kDestination" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": []
                                      }
                                    }
                                  }
                                }
                              }
                            },
                            {
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "Move" },
                                "localizationKey": { "string": "Signature.fsops.device.kMove" },
                                "id": { "string": "Move" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "File Access" },
                                            "localizationKey": { "string": "Signature.fsops.device.kFileAccess" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"EnumDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultMemberId": { "string": "Direct Access" },
                                                "enumMembers": [{
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Direct Access" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kDirectAccess" },
                                                    "id": { "string": "Direct Access" }
                                                  }
                                                },
                                                {
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Via RFS" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kViaRFS" },
                                                    "id": { "string": "Via RFS" }
                                                  }
                                                }],
                                                "showAsRadioButton": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Source" },
                                            "localizationKey": { "string": "Signature.fsops.device.kSource" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Destination" },
                                            "localizationKey": { "string": "Signature.fsops.device.kDestination" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": []
                                      }
                                    }
                                  }
                                }
                              }
                            },
                            {
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "Rename" },
                                "localizationKey": { "string": "Signature.fsops.device.kRename" },
                                "id": { "string": "Rename" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "File Access" },
                                            "localizationKey": { "string": "Signature.fsops.device.kFileAccess" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"EnumDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultMemberId": { "string": "Direct Access" },
                                                "enumMembers": [{
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Direct Access" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kDirectAccess" },
                                                    "id": { "string": "Direct Access" }
                                                  }
                                                },
                                                {
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Via RFS" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kViaRFS" },
                                                    "id": { "string": "Via RFS" }
                                                  }
                                                }],
                                                "showAsRadioButton": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Item" },
                                            "localizationKey": { "string": "Signature.fsops.device.kItem" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "New Name" },
                                            "localizationKey": { "string": "Signature.fsops.device.kNewName" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": []
                                      }
                                    }
                                  }
                                }
                              }
                            },
                            {
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "Get Type" },
                                "localizationKey": { "string": "Signature.fsops.device.kGetType" },
                                "id": { "string": "Get Type" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "File Access" },
                                            "localizationKey": { "string": "Signature.fsops.device.kFileAccess" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"EnumDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultMemberId": { "string": "Direct Access" },
                                                "enumMembers": [{
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Direct Access" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kDirectAccess" },
                                                    "id": { "string": "Direct Access" }
                                                  }
                                                },
                                                {
                                                  "meta":{
                                                    "className":"DasEnumMember",
                                                    "version":1
                                                  },
                                                  "gizmo":{
                                                    "name": { "string": "Via RFS" },
                                                    "localizationKey": { "string": "Signature.fsops.device.kViaRFS" },
                                                    "id": { "string": "Via RFS" }
                                                  }
                                                }],
                                                "showAsRadioButton": { "boolean": "false" }
                                              }
                                            }
                                          }
                                        },
                                        {
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Item" },
                                            "localizationKey": { "string": "Signature.fsops.device.kItem" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Type" },
                                            "localizationKey": { "string": "Signature.fsops.device.kType" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    }
                                  }
                                }
                              }
                            },
                            {
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "Close All Directories" },
                                "localizationKey": { "string": "Signature.fsops.device.kCloseAllDirectories" },
                                "id": { "string": "Close All Directories" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": []
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": []
                                      }
                                    }
                                  }
                                }
                              }
                            },
                            {
                              "meta":{
                                "className":"DasVariant",
                                "version":1
                              },
                              "gizmo":{
                                "name": { "string": "Get Last Error" },
                                "localizationKey": { "string": "Signature.fsops.device.kGetLastError" },
                                "id": { "string": "Get Last Error" },
                                "typeDefinition": {
                                  "meta":{
                                    "className":"MethodDasType",
                                    "version":0
                                  },
                                  "gizmo":{
                                    "argumentsType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": []
                                      }
                                    },
                                    "returnType": {
                                      "meta":{
                                        "className":"RecordDasType",
                                        "version":0
                                      },
                                      "gizmo":{
                                        "fields": [{
                                          "meta":{
                                            "className":"DasField",
                                            "version":2
                                          },
                                          "gizmo":{
                                            "name": { "string": "Error" },
                                            "localizationKey": { "string": "Signature.fsops.device.kError" },
                                            "optional": { "boolean": "false" },
                                            "collapsible": { "boolean": "false" },
                                            "typeDefinition": {
                                              "meta":{
                                                "className":"StringDasType",
                                                "version":0
                                              },
                                              "gizmo":{
                                                "defaultValue": { "string": "" }
                                              }
                                            }
                                          }
                                        }]
                                      }
                                    }
                                  }
                                }
                              }
                            }],
                            "showAsCheckbox": { "boolean": "false" }
                          }
                        }
                      }
                    }]
                  }
                }
              }
            }
          }
        },
        {
          "meta":{
            "className":"ReturnStep",
            "version":1
          },
          "gizmo":{
            "name": {
              "meta":{
                "className":"StepName",
                "version":0
              },
              "gizmo":{
                "customName": { "string": "" }
              }
            },
            "comment": {
              "meta":{
                "className":"Comment",
                "version":0
              },
              "gizmo":{
                "comment": { "string": "" }
              }
            },
            "values": []
          }
        }]
      }
    }
  }
}</body>
</object>
