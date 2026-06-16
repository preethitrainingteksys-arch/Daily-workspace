import React from "react";
import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  Tooltip,
  CartesianGrid,
  Cell
} from "recharts";

function StatusChart({ notes }) {

  const openCount = notes.filter(note => note.status === "open").length;
  const closedCount = notes.filter(note => note.status === "closed").length;

  const data = [
    { name: "Open", value: openCount },
    { name: "Closed", value: closedCount }
  ];

  const colors = ["#010a01", "#111010"];

  return (

    <div
      style={{
        display: "flex",
        justifyContent: "center",
        marginTop: "20px"
      }}
    >

      <div>

        <h3 style={{ textAlign: "center" }}>
          Status Chart
        </h3>

        <BarChart
          width={200}
          height={350}
          data={data}
        >

          <CartesianGrid strokeDasharray="3 3" />

          <XAxis dataKey="name" />

          <YAxis />

          <Tooltip />

          <Bar dataKey="value">

            {data.map((entry, index) => (

              <Cell
                key={entry.name}
                fill={colors[index]}
              />

            ))}

          </Bar>

        </BarChart>

      </div>

    </div>

  );
}

export default StatusChart;